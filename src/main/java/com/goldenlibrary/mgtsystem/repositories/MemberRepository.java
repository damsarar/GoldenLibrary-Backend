package com.goldenlibrary.mgtsystem.repositories;

import com.goldenlibrary.mgtsystem.models.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
    @Override
    void delete(Member deleted);

}