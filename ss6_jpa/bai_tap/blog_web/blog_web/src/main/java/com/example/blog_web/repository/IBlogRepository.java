package com.example.blog_web.repository;

import com.example.blog_web.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findBlogsByNameContaining(String name);


    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    List<Blog> findBlogsByCategoryBlog(@Param("id") int id);

    @Query(value = "select * from blog where name like :name ", nativeQuery = true)
    Page<Blog> search(@Param("name") String name, Pageable pageable);
    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    Page<Blog> searchByCategory(Pageable pageable, @Param("id") int id);
    @Query(value = "select * from blog where category_id =:id and name like :name", nativeQuery = true)
    Page<Blog> searchByCategoryAndName(@Param("name") String name,Pageable pageable, @Param("id") int id);
}
