import React, { useState } from 'react';
import { Button, Form, FormGroup, Input, Label, FormText } from 'reactstrap';
import './index.css'
import imagem from './padrao.jpg'
export default function Formulario() {


    const baseURL = "http://localhost:8080/pessoa";

    const [post_nome, setPost_nome] = useState("");
    const [post_cpf, setPost_cpf] = useState("");
    const [post_matricula, setPost_matricula] = useState("");
    const [post_senha, setPost_senha] = useState("0");
    const[post_usuario, setPost_usuario] =useState("A");
    const [post_foto, setPost_foto] =useState(imagem)

    async function postData() {
        const postData = {
            nome: post_nome,
            matricula: post_matricula,
            cpf: post_cpf,
            usuario:post_usuario,
            senha:post_senha,
            foto: post_foto
        };

        console.log(postData);

        try {
            await fetch(`${baseURL}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(postData),
            });

        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className="Form-box">
            <Form>
                <FormGroup>
                    <div className="alinhar">
                        <div className="UserAtributes-box">
                            <Label for="nome"></Label>
                            <Input  id="nome" value={post_nome} onChange={(e) => setPost_nome(e.target.value)} type='text' placeholder='Informe o nome do usuário' />
                        </div>
                        <div className="UserAtributes-box">
                            <Label for="cpf"></Label>
                            <Input id="cpf" type="text" value={post_cpf} onChange={(e) => setPost_cpf(e.target.value)} pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"
                                placeholder="Digite um CPF no formato: xxx.xxx.xxx-xx" />
                        </div>
                        <div className="UserAtributes-box">
                            <Label for="matricula"></Label>
                            <Input id="matricula" placeholder='Matricula:' type="number" value={post_matricula} onChange={(e) => setPost_matricula(e.target.value)} />
                        </div>
                        <div className="UserAtributes-box">
                            <Label placeholder='Nascimento' for="nascimento"></Label>
                            <Input id="nascimento" placeholder='Nascimento' type="date" />
                        </div>
                        <div className="UserAtributes-box">
                            <FormGroup>
                                <div className="gridG">
                                    <Label for="genero">Genero:</Label>
                                    <FormGroup  check>
                                        <Label check>
                                            <Input type="radio" name="genero" value={'Masculino'} /> Masculino
                                        </Label>
                                    </FormGroup>
                                    <FormGroup  check>
                                        <Label check>
                                            <Input type="radio" name="genero" value={'Feminino'} /> Feminino
                                        </Label>
                                    </FormGroup>
                                    <FormGroup  check>
                                        <Label check>
                                            <Input type="radio" name="genero" value={'Outro'} /> Outro
                                        </Label>
                                    </FormGroup>
                                </div>
                            </FormGroup>
                        </div>
                        <div className="UserAtributes-box">
                            <div className='position-relative'>
                                <Label for="foto">:</Label>
                            </div>
                            <Input  id="foto" placeholder='foto' type="file" />

                            <FormText color="muted">
                                Foto para reconhecimento.
                            </FormText>
                        </div>
                    </div>
                </FormGroup>
                <Button onClick={postData}>Gravar</Button>
            </Form>
        </div>
    );
}