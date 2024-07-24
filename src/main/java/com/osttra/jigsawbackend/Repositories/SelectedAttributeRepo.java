package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.SelectedAttribute;

@Repository
public interface SelectedAttributeRepo extends JpaRepository<SelectedAttribute, Integer> {

}
