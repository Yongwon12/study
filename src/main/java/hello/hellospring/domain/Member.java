package hello.hellospring.domain;

public class Member {

    private Long id;  // 고객이 저장하는 id가 아닌 시스템이 저장하는 id
    private String name; // 고객이 적은 name

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
