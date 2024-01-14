package yhproject.playground.springevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yhproject.playground.springevent.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

}
