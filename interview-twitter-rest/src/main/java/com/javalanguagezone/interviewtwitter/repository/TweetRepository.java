package com.javalanguagezone.interviewtwitter.repository;

import com.javalanguagezone.interviewtwitter.domain.Tweet;
import com.javalanguagezone.interviewtwitter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
  List<Tweet> findAllByAuthor(User author);

  //old way using @Query annotation
  @Query("select count(*) from Tweet t where t.author.username=:username")
  long countTweetsByUser(@Param("username") String username);

  //using query derivation
  long countTweetsByAuthor_Username(String username);

}
