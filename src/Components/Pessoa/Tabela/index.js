import React, { useEffect, useState, useRef } from 'react';
import { Table, Button } from 'reactstrap';
import './index.css'

export default function Tabela() {

    const baseURL = "http://localhost:8080/pessoa";

    const delete_id = useRef(null);

    const [users, setUsers] = useState([]);

    useEffect(() => {
        load();
    }, []);

    async function load() {
        await fetch(`${baseURL}`, {
            method: 'GET',
        })
            .then(data => {
                return data.json();
            })
            .then(data => {
                setUsers(data);
            })
            .catch(err => {
                console.log(err);
            });
    }

    async function deleteAll() {
        await fetch(`${baseURL}`, {
            method: "delete"
        })
            .then(res => res.json())
            .then(res => console.log(res));
    }

    async function deleteById() {
        const id = delete_id.current.value;

        if (id) {
            await fetch(`${baseURL}/${id}`, { method: "delete" })
                .then(res => res.json())
                .then(res => console.log(res))
        }
    }

    return (
        <Table className="table-bordered text-center">
            <thead className="thead-d">
                <tr>
                    <th className='branquinho' >ID</th>
                    <th className='branquinho'>Foto</th>
                    <th className='branquinho'>Nome</th>
                    <th className='branquinho'>CPF</th>
                    <th className='branquinho'>Matrícula</th>
                    <th className='branquinho'>Nascimento</th>
                    <th className='branquinho'>Genero</th>
                    <th className='branquinho'>Ações</th>
                </tr>
            </thead>
            <tbody>
                {users.map(user => (
                    <tr>
                        <td className='branquinho' ref={delete_id}>{user.idpessoa}</td>
                        <td className='branquinho '><img className='fotos' src={user.foto} alt="foto" /></td>
                        <td className='branquinho'>{user.nome}</td>
                        <td className='branquinho'>{user.cpf}</td>
                        <td className='branquinho'>{user.matricula}</td>
                        <td className='branquinho'>{user.nascimento}</td>
                        <td className='branquinho'>{user.genero}</td>
                        <td className='branquinho'>
                            <Button color="info" size="sm" >Editar</Button>
                            <Button color="danger" size="sm" onClick={deleteById}>Deletar</Button>
                        </td>
                    </tr>
                ))}
            </tbody>
            <Button color="danger" size="sm" onClick={deleteAll}>Delete All</Button>
        </Table>
    );
}