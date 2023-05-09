"use client"
import { useEffect, useState } from 'react'
import axios from "axios";

class User {
  id: number | undefined;
  name: string | undefined;
}
export default function Home() {

  const [listOfUsers, setListOfUsers] = useState<User[]>([]);
  
  useEffect(() => {
    axios.get("http://localhost:8080/user").then((response) => {
      setListOfUsers(response.data);
    });
  }, [])

  return (
    <div>
      <h2>Lista de Usuarios</h2>
      <div>
        <table>
          <th><td>id</td><td>Name</td></th>
          
            {listOfUsers.map((value,id)=>
              <tr><td>{value.id}</td><td>{value.name}</td></tr>)}
        
        </table>
      </div>
    </div>

  )
}
