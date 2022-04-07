package br.com.felipeaulas.projetoum.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByName(String name);
    List<Client> findAllByClientType(ClientType clientType);
}
