package com.team.players.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


	@Entity
	@NamedQuery(name="find_all_players", query = "select p from Players p")
	@Table(name = "players")
	public class Players {
		
		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		private String pos;
		private String team;
		private String bench;
		private double points;


		public Players() {
		
		}
		
		public Players(String id, String pos, String team, String bench, double points) {
			this.id = id;
			this.pos = pos;
			this.team = team;
			this.bench = bench;
			this.points = points;
		}
		
//		public Players(String pos, String team, String bench, double points) {
//			
//			this.pos = pos;
//			this.team = team;
//			this.bench = bench;
//			this.points = points;
//		}
		
		public Players(String id, String pos) {
			this.id = id;
			this.pos = pos;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPos() {
			return pos;
		}

		public void setPos(String pos) {
			this.pos = pos;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public String getBench() {
			return bench;
		}

		public void setBench(String bench) {
			this.bench = bench;
		}

		public double getPoints() {
			return points;
		}

		public void setPoints(double points) {
			this.points = points;
		}

		@Override
		public String toString() {
			return "id=" + id + ", pos=" + pos + ", team=" + team + ", bench=" + bench + ", points=" + points;
		}
		
		

}
