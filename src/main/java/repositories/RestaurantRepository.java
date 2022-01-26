package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	
	// metodo que busca restaurante por id 
	Optional<Restaurant> findById(Long id);
	
	// metodo que busca por nombre
	Optional<Restaurant> findByName(String name);
	
	
	// metodo que busca por restaurante
	// HQL
	@Query("SELECT REST From Restaurant REST")
	public List<Restaurant> findByRestaurant();
	
}
