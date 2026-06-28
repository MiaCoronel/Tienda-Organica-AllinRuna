error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/repository/UsuarioRepository.java:_empty_/Usuario#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/repository/UsuarioRepository.java
empty definition using pc, found symbol in pc: _empty_/Usuario#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 314
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/repository/UsuarioRepository.java
text:
```scala
package com.example.segundoAvance.repository;

import com.example.segundoAvance.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<@@Usuario, Long> {
    // Spring Data JPA usará este método para buscar un usuario por su email
    // al momento de iniciar sesión.
    Optional<Usuario> findByEmail(String email);
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Usuario#