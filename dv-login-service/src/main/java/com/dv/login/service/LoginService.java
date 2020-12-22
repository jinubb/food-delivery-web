package com.dv.login.service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dv.common.UserSession;
import com.dv.login.entity.Store;
import com.dv.login.entity.User;
import com.dv.login.model.LoginResponse;
import com.dv.login.repository.StoreRepository;
import com.dv.login.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	private static final int tokenExpiredTime = 1800; // 토큰 유효시간 1800sec
	
	private String createToken(UserSession newUserSession, int expiredTime) {
		HttpSession newSession = createSession(); //새로운 세션 생성
		newSession.setAttribute("loginInfo", newUserSession);
		newSession.setMaxInactiveInterval(expiredTime);
		return newSession.getId();
	}
	
	private UserSession createUserSession(User loginUser) {
		UserSession newUserSession = new UserSession();
		newUserSession.setUserType(loginUser.getType());
		newUserSession.setId(loginUser.getId());
		newUserSession.setName(loginUser.getName());
		newUserSession.setEmail(loginUser.getEmail());
		newUserSession.setPhone(loginUser.getPhone());
		return newUserSession;
	}
	
	private HttpSession createSession() {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession newSession = servletRequestAttribute.getRequest().getSession(true);
	    return newSession;
	}
	
	//로그인
	public LoginResponse loginUser(String email, String password) {
		LoginResponse res = new LoginResponse();
		User loginUser = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("등록되지 않은 Email입니다."));
		if(!loginUser.getPassword().equals(password)) {
			throw new RuntimeException("비밀번호가 맞지 않습니다.");
		}
		
		res.setAuthToken(createToken(createUserSession(loginUser), tokenExpiredTime));
		res.setLoginUser(loginUser);
		return res;
	}

	//회원가입
	@Transactional
	public User registerUser(String email, String password, String name, String phone, String type, String storeName, String storePhone, String storeType) {
		isValidEmail(email);
		Long storeId = null;
		
		//업체 등록
		if(storeName != null) {
			storeId = createStore(storeName, storePhone, storeType).getId();
		}
		
		User newUser = createUser(email, password, name, phone, type, storeId);
		return userRepo.save(newUser);
	}

	private Store createStore(String storeName, String storePhone, String storeType) {
		Store newStore = new Store();
		newStore.setName(storeName);
		newStore.setPhone(storePhone);
		newStore.setType(storeType);
		return storeRepo.save(newStore);
	}

	private boolean isValidEmail(String email) {
		if(userRepo.findByEmail(email).isPresent()) {
			throw new RuntimeException("이미 등록된 이메일입니다.");
		}
		return true;
	}

	private User createUser(String email, String password, String name, String phone, String userType, Long storeId) {
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setName(name);
		newUser.setPhone(phone);
		newUser.setType(userType);
		newUser.setStoreId(storeId);
		return newUser;
	}
	
	

}
