package com.main_39.Spring.member.repository;

import com.main_39.Spring.member.entity.Kakao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KakaoRepository extends JpaRepository<Kakao,Long> {
    Optional<Kakao> findByEmail(String email);

    Optional<Kakao> findByNickname(String nickname);
}