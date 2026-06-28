// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.example.segundoAvance.controller;

import com.example.segundoAvance.model.Pedido;
import com.example.segundoAvance.model.Producto;
import com.example.segundoAvance.model.Usuario;
import com.example.segundoAvance.repository.PedidoRepository;
import com.example.segundoAvance.repository.ProductoRepository;
import com.example.segundoAvance.repository.UsuarioRepository;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/admin" })
public class AdminController {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminController() {
    }

    @GetMapping({ "/dashboard" })
    public String dashboard(Model model) {
        model.addAttribute("totalProductos", this.productoRepository.count());
        model.addAttribute("totalUsuarios", this.usuarioRepository.count());
        model.addAttribute("totalPedidos", this.pedidoRepository.count());
        model.addAttribute("pedidosRecientes", pedidoRepository.findAllByOrderByFechaDesc().stream().limit(5).collect(java.util.stream.Collectors.toList()));

        return "admin/dashboard";
    }

    @GetMapping({ "/productos/add" })
    public String addProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "admin/add-producto";
    }

    @PostMapping({ "/productos/add" })
    public String postAddProducto(@ModelAttribute("producto") Producto producto) {
        this.productoRepository.save(producto);
        return "redirect:/admin/productos/editar";
    }

    @GetMapping({ "/productos/editar" })
    public String editarProductos(Model model) {
        model.addAttribute("productos", this.productoRepository.findAll());
        return "admin/editar-productos";
    }

    @PostMapping({ "/productos/delete/{id}" })
    public String deleteProducto(@PathVariable Long id) {
        this.productoRepository.deleteById(id);
        return "redirect:/admin/productos/editar";
    }

    @GetMapping({ "/productos/edit/{id}" })
    public String editProducto(@PathVariable Long id, Model model) {
        Optional<Producto> producto = this.productoRepository.findById(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "admin/edit-producto";
        } else {
            return "redirect:/admin/productos/editar";
        }
    }

    @PostMapping({ "/productos/edit/{id}" })
    public String postEditProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto) {
        Producto productoExistente = (Producto) this.productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setImagen(producto.getImagen());
        this.productoRepository.save(productoExistente);
        return "redirect:/admin/productos/editar";
    }

    @GetMapping({ "/usuarios" })
    public String gestionarUsuarios(Model model) {
        model.addAttribute("usuarios", this.usuarioRepository.findAll());
        return "admin/gestionar-usuarios";
    }

    @GetMapping({ "/usuarios/crear" })
    public String crearUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/crear-usuario";
    }

    @PostMapping({ "/usuarios/crear" })
    public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles("ROLE_USER");
        }

        this.usuarioRepository.save(usuario);
        return "redirect:/admin/usuarios";
    }

    @PostMapping({ "/usuarios/cambiar-rol" })
    public String cambiarRolUsuario(@RequestParam("id") Long id, @RequestParam("rol") String rol) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = (Usuario) usuarioOpt.get();
            usuario.setRoles(rol);
            this.usuarioRepository.save(usuario);
        }

        return "redirect:/admin/usuarios";
    }

    @PostMapping({ "/usuarios/eliminar" })
    public String eliminarUsuario(@RequestParam("id") Long id, Principal principal) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = (Usuario) usuarioOpt.get();
            if (principal != null && principal.getName().equals(usuario.getEmail())) {
                return "redirect:/admin/usuarios";
            }

            this.usuarioRepository.delete(usuario);
        }

        return "redirect:/admin/usuarios";
    }

    @GetMapping({ "/pedidos" })
    public String verPedidos(Model model) {
        model.addAttribute("pedidos", this.pedidoRepository.findAllByOrderByFechaDesc());
        return "admin/ver-pedidos";
    }

    @GetMapping({ "/pedidos/detalle/{id}" })
    public String verDetallePedido(@PathVariable Long id, Model model) {
        Pedido pedido = this.pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("usuario", pedido.getUsuario());
            model.addAttribute("items", pedido.getDetalles());
        }

        return "admin/ver-detalle-pedido";
    }

    @PostMapping({ "/pedidos/actualizar-estado" })
    public String actualizarEstadoPedido(@RequestParam("pedidoId") Long pedidoId,
            @RequestParam("estado") String estado) {
        Optional<Pedido> pedidoOpt = this.pedidoRepository.findById(pedidoId);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = (Pedido) pedidoOpt.get();
            pedido.setEstado(estado);
            this.pedidoRepository.save(pedido);
        }

        return "redirect:/admin/pedidos/detalle/" + String.valueOf(pedidoId);
    }

    @Transactional
    @GetMapping({ "/pedidos/delete/{id}" })
    public String deletePedido(@PathVariable Long id) {
        Optional<Pedido> pedidoOpt = this.pedidoRepository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = (Pedido) pedidoOpt.get();
            Usuario usuario = pedido.getUsuario();
            if (usuario != null) {
                usuario.getPedidos().remove(pedido);
            }

            this.pedidoRepository.delete(pedido);
        }

        return "redirect:/admin/pedidos";
    }

}
