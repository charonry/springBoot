package com.charon.boot.jpa.bootjpa2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-06 15:35
 **/
public interface MessageRepository extends JpaRepository<Message,Long> {
}
