package com.example.demo.Controllers;




import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ChucNang;
import com.example.demo.models.PhongBan;

@RestController
@RequestMapping("/kiemtra")
public class CheckController {
	@PostMapping("/phongban")
	
	
	public PhongBan kiemtra1(@Valid @RequestBody PhongBan phongban) {
		System.out.println("haubeoddd");
		
		System.out.println(phongban.getName()+" mm"+phongban.getMapb());
		return phongban;
	}
	
@PostMapping("/ChucNangkt")
public String kiemtra (@Valid @RequestBody ChucNang cn,BindingResult bindingResult) {

			return "haubeo";
}


//th:field="*{name}"
//<span th:errors="*{name}" class=error"></span>
//<td th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</td>
/// <td><input type="text" th:field="*{age}" /></td>
//<td th:if="${#fields.hasErrors('age')}" th:errors="*{age}">Age Error</td>
//@NotBlank 
/*if (errors.hasErrors()) {

    result.setMsg(errors.getAllErrors()
                .stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(",")));

    return ResponseEntity.badRequest().body(result);

}*/

}
