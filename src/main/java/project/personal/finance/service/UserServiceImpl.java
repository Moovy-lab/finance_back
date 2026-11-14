package project.personal.finance.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.personal.finance.dto.UserDTO;
import project.personal.finance.entities.User;
import project.personal.finance.exception.DataNotFoundException;
import project.personal.finance.mapper.UserMapper;
import project.personal.finance.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO ajouter(UserDTO userDTO) {
        User userSaved = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(userSaved);
    }

    @Override
    public UserDTO modifier(UserDTO userDTO) {
        User userModified = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(userModified);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> recupererListeDesUtilisateurs() {
        return userRepository.findAll().stream().map(user -> userMapper.toDto(user)).toList();
    }

    @Override
    public UserDTO findById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow(()-> new DataNotFoundException("utilisateur introuvable"));
    }
}
