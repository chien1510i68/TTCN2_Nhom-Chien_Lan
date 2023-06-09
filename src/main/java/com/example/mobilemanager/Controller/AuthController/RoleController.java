package com.example.mobilemanager.Controller.AuthController;

import com.example.mobilemanager.Entity.Role;
import com.example.mobilemanager.Model.DTO.RoleDTO;
import com.example.mobilemanager.Request.RoleRequest.CreateRoleRequest;
import com.example.mobilemanager.Request.RoleRequest.GetListRoleRequest;
import com.example.mobilemanager.Request.RoleRequest.UpdateRoleRequest;
import com.example.mobilemanager.Response.ResponseError.BaseResponse;
import com.example.mobilemanager.Service.AuthService.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends BaseController {
    private final RoleService roleService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority('CREATE_ROLE','ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody CreateRoleRequest request) {
        RoleDTO response = roleService.createRole(request);
        return buildItemResponse(response);
    }

    @PutMapping("")
    @PreAuthorize("hasAnyAuthority('UPDATE_ROLE', 'ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateRoleRequest request) {
        RoleDTO response = roleService.updateRole(request);
        return buildItemResponse(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('UPDATE_ROLE', 'ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        BaseResponse response = new BaseResponse();
        roleService.deleteRole(id);
        response.setSuccess(true);
        return buildItemResponse(response);
    }

    @PostMapping("/list")
    public ResponseEntity<?> getRoles(@Valid @RequestBody GetListRoleRequest request) {
        Page<Role> page = roleService.getAllRoles(request);
        List<RoleDTO> response = page.getContent().stream().map(role -> modelMapper.map(role, RoleDTO.class)).collect(Collectors.toList());
        return buildListItemResponse(response, page.getTotalElements());
    }

}
