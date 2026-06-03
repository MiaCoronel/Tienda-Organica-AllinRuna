error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/model/Usuario.java:_empty_/Column#unique#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/model/Usuario.java
empty definition using pc, found symbol in pc: _empty_/Column#unique#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 429
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/HERRAMIENTAS%20DE%20DESARROLLO/GitHub/v1.1.2/Tienda-Organica-AllinRuna/src/main/java/com/example/segundoAvance/model/Usuario.java
text:
```scala
package com.example.segundoAvance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, uni@@que = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String roles; // El campo se llama 'roles' (plural)

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidos;


    // --- ¡AQUÍ ESTÁ EL ARREGLO! ---
    // Añadimos el "setter" manualmente para que Java lo encuentre
    // y el error en AdminController desaparezca.
    public void setRoles(String roles) {
        this.roles = roles;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Column#unique#