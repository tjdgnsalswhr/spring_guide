package com.example.demo.user.core.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.user.core.application.object.UserRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j						//로그 기록을 위한 Annotation
@ToString					//tostring method 자동 생성
@NoArgsConstructor			//파라미터가 없는 생성자 생성
@Getter						//getter 자동 생성
@Setter						//setter 자동 생성
@Table(name="users")		//entity 와 매핑할 테이블. 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용
@Entity						//JPA를 사용해서 테이블과 매핑할 클래스. JPA가 관리한다는 뜻임.
public class User {
	
	@Id
	String uId;
	String uPw;
	String uName;
	
	@Builder
	public User(String uId, String uPw, String uName)
	{
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
	}
	
	public UserRequestDTO update(UserRequestDTO userRequestDTO)
	{
		userRequestDTO.setUId(userRequestDTO.getUId());
		userRequestDTO.setUPw(userRequestDTO.getUPw());
		userRequestDTO.setUName(userRequestDTO.getUName());
		return userRequestDTO;
				
	}
	

}
