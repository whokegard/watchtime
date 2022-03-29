<<<<<<<< HEAD:src/main/java/com/example/watchtime/reprository/MemberRepository.java
package com.example.watchtime.reprository;
========
package com.example.watchtime.repository;
>>>>>>>> origin/master:src/main/java/com/example/watchtime/repository/MemberRepository.java

import com.example.watchtime.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
