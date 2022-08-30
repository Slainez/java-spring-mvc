
package fr.m2i.springmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class StudentForm {
    
    @NotNull(message= "This field is mandatory")
    @Min(value = 15 , message = "Enter a valid age for a student")
    private Integer age ;
    
    @NotBlank(message= "This field is mandatory")
    private String name ;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
