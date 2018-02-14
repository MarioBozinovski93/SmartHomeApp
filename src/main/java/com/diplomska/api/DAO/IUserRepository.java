/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.DAO;

 
 
import com.diplomska.api.Models.Device;
import com.diplomska.api.Models.Role;
import com.diplomska.api.Models.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Mario HP
 */
public interface IUserRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    @Query("SELECT r FROM Role r WHERE r.category = ?")
    public Role getRoleByCat(int category);
    
    @Query("SELECT d FROM Device d WHERE d.RelaySlotNumber = ?")
    public Device getDeviceBySlot(int slot);

//    @Query("SELECT r FROM Reservation r WHERE r.meetStarts = ?")
//    public List<Reservation> getResByMeetStarts(Date meetStarts);
//
//    @Query("SELECT r FROM Reservation r WHERE r.meetEnds = ?")
//    public List<Reservation> getResByMeetEnds(Date meetEnds);
//
////    @Query("SELECT r FROM Reservation r WHERE r.room = :roomId and r.meetStarts = :meetStarts")
////    public boolean resRoomExists(int roomId, Date meetStarts);
//
//     @Query("SELECT r FROM Reservation r WHERE r.room.roomId = ?")
//    public Reservation resRoomExists(int roomId);
//    
//    @Query("SELECT r FROM Room r")
//    public List<Room> getAllRooms();
//    
//    @Query("SELECT r FROM Reservation r JOIN r.room res WHERE res.roomId = ?")
//    public List<Reservation> getAllReservationsByRoom(int roomId);
//   
//
//    @Query("SELECT u FROM User u  WHERE u.email=:email and u.userName=:userName")
//    public User getAllUsersWithMatchingEmail(@Param("email") String email, @Param ("userName")String userName);

}
