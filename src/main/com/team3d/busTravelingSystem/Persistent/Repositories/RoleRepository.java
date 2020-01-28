package main.com.team3d.busTravelingSystem.Persistent.Repositories;


import main.com.team3d.busTravelingSystem.Persistent.Models.Role;

public class RoleRepository extends CrudRepository<Role,Long> {
    private static RoleRepository roleRepository;

    private RoleRepository() {

    }

    public static RoleRepository getInstance() {
        if (roleRepository == null) {
            roleRepository = new RoleRepository();
        }
        return roleRepository;
    }
    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
