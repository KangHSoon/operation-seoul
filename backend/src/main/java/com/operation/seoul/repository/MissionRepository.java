package com.operation.seoul.repository;

import com.operation.seoul.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받으면 기본 CRUD(생성,조회,수정,삭제) 기능이 자동으로 만들어집니다!
public interface MissionRepository extends JpaRepository<Mission, Long> {
}