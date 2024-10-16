package shop.samdul.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.samdul.greeting.entity.People;

import java.util.Stack;

@Controller
@Slf4j
public class GreetingController {

    Stack<People> newStack = new Stack<>(); // newlist = []

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue = "Hi") String name,
            Model model) {

        Integer index = 0;

        if(newStack.isEmpty()) {
            index = 1;

        }else{
            People peek = newStack.peek();
            index = peek.getIndex() + 1;
        }

        /*people 생성*/
        People people = new People(index, name); /*방법 1*/

        /*방법 2
        people.setName(name);
        people.setIndex(index);*/

        /*생성된 people을 stack에 넣기*/
        newStack.add(people);
        log.info(newStack.toString());

        model.addAttribute("manggeeisfree", newStack);

        return "greeting";
    }


}
