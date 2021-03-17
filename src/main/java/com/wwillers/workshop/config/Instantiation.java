package com.wwillers.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.wwillers.workshop.domain.Post;
import com.wwillers.workshop.domain.User;
import com.wwillers.workshop.dto.AuthorDTO;
import com.wwillers.workshop.dto.CommentDTO;
import com.wwillers.workshop.repository.PostRepository;
import com.wwillers.workshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository repo;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    repo.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    repo.saveAll(Arrays.asList(maria, alex, bob));

    Post firstPost = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP, abraços!",
        new AuthorDTO(maria));
    Post secondPost = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Estou muito feliz", new AuthorDTO(maria));

    CommentDTO firstComment = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
    CommentDTO secondComment = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
    CommentDTO thirdComment = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

    firstPost.getComments().addAll(Arrays.asList(firstComment, secondComment));
    secondPost.getComments().addAll((Arrays.asList(thirdComment)));

    postRepository.saveAll(Arrays.asList(firstPost, secondPost));

    maria.getPosts().addAll(Arrays.asList(firstPost, secondPost));

    repo.save(maria);

  }

}
