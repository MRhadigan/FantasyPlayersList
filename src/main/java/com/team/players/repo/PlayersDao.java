package com.team.players.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.team.players.entity.Players;

@Repository
@Transactional
public class PlayersDao {

	@PersistenceContext
	EntityManager eManager;

	public Players findById(String id) {
		return eManager.find(Players.class, id);
	}

	public List<Players> findAll() {
		TypedQuery<Players> namedQuery = eManager.createNamedQuery("find_all_players", Players.class);
		return namedQuery.getResultList();
	}

	public Players update(Players p) {
		return eManager.merge(p);
	}

	public void deleteById(String id) {
		Players p1 = findById(id);
		eManager.remove(p1);
	}
}
