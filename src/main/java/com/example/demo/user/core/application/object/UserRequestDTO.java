package com.example.demo.user.core.application.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
	
	@ApiModelProperty(example = "uId01")
	String uId;
	
	@ApiModelProperty(example = "uPw01")
	String uPw;
	
	@ApiModelProperty(example = "uName01")
	String uName;

}
