
package fr.m2i.springmvc.controller;

import fr.m2i.springmvc.form.StudentForm;
import fr.m2i.springmvc.model.Student;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    
     /*
     * 1ere solution -> notre méthode prend en paramètre le model pour pouvoir
     *                 SET notre bean StudentForm pour le bon fonctionnement de notre form côté JSP
     *                 la méthode doit retourner une String : le nom de la vue qu'on souhaite afficher
     */
//    @GetMapping("/student")
//    public String showStudentForm(ModelMap model) {
//        model.addAttribute("studentForm", new StudentForm());
//        return "student";
//    }

    /*
     * 2eme solution -> notre méthode travaille avec ModelAndView on doit spécifier dans l'ordre
     *                 le nom de la vue qu'on veut afficher, le nom du modelAttribute utiliser par le formulaire
     *                 la valeur de l'attribut
     */
//    @GetMapping("/student")
//    public ModelAndView showStudentForm() {
//        return new ModelAndView("student", "studentForm", new StudentForm());
//    }

    /*
     * 3eme solution -> On travaille en injection de dépendance avec la méthode 'addStudentForm' 
     *                 donc notre GET a juste besoin de retourner le de la vue a afficher
     */
    @GetMapping("/student")
    public String showStudentForm() {
        return "student";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("studentForm")  @Valid StudentForm student ,
                                        BindingResult result , ModelMap model) {
        
        if ( result.hasErrors()){
            return "student";
        }
        
        model.addAttribute("id", 1);
        model.addAttribute("age", student.getAge());
        model.addAttribute("name", student.getName());

        return "result";
    }

    // 3 eme solution -> injection de dépendance
    @ModelAttribute("studentForm")
    public StudentForm addStudentForm() {
        return new StudentForm();
    }
}
