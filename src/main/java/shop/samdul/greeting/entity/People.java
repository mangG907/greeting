package shop.samdul.greeting.entity;

import lombok.Data;

@Data
public class People {

    private Integer index;
    private String name;

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }

    /*void 는 return이 없다*/

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }


    public People(Integer index, String name) {
        this.index = index;
        this.name = name;
    }
}
