package lab5.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import lab5.trees.Trees;

@RepositoryRestResource
@CrossOrigin(origins = "*")
//@RepositoryRestResource(collectionResourceRel = "trees", path = "trees")
public interface treesRepository extends JpaRepository<Trees, Integer> {

  //List<Trees> findByTitle(@Param("title") String title);
}

