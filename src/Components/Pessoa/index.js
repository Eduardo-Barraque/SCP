import React from 'react';
import './index.css'

import Formulario from './Formulario';
import Tabela from './Tabela';

function PessoaBox() {

    return (
        <div>
            <div className="row gridd">
                <div className=" grid2">
                    <h2 className="font-weight-bold text-center cor"> Cadastro de Pessoas </h2>
                    <Formulario />
                </div>
                <div className=" grid1">
                    <h2 className="font-weight-bold text-center cor"> Lista de Pessoas </h2>
                    <Tabela />
                </div>
            </div>
        </div>
    );
}
export default PessoaBox;