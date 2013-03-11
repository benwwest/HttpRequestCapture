package com.benwwest.notify.repository;

import org.springframework.data.repository.CrudRepository;

import com.benwwest.notify.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
	
}
