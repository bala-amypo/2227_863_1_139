import com.example.demo.entity.Role;

@Override
public String register(RegisterRequest request) {

    Role role;
    try {
        role = Role.valueOf(request.getRole().toUpperCase());
    } catch (Exception e) {
        throw new RuntimeException("Invalid role");
    }

    if (userRepo.findByEmail(request.getEmail()).isPresent()) {
        throw new RuntimeException("Email already registered");
    }

    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(encoder.encode(request.getPassword()));
    user.setRoles(Set.of("ROLE_" + role.name()));

    userRepo.save(user);

    return "User registered successfully";
}