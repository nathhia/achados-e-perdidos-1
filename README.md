#Este projeto tem como objetivo criar um sistema de catalogação e busca para objetos que foram perdidos e posteriormente encontrados, nas dependências da universidade [UFRPE]. O objetivo é que os alunos e professores(usuários) deixem de utilizar o email pessoal para informar pelo programa algum item achado ou perdido. Deixando assim, um sistema objetivo, prático e email pessoal deixando de parecer um "fórum". Serão implementadas funções de cadastro de objetos perdidos, que terá um campo para descrever as categorias de acordo com o tipo de objeto (eletrônico, vestível, alto ou baixo valor, etc), local onde foi encontrado, departamento no qual se encontra para retirada, dentre outros aspectos e também será implementada uma interface de consulta de itens encontrados.

#O usuário deverá logar no sistema atrevés de um login por cpf e senha. Caso o usuário não esteja cadastrado ele deverá num hiperlink abaixo do login "Ainda não é cadastrado? Clique aqui". Ele será direcionado para uma tela de cadastro e fará o seu para ter acesso ao sistema.
#Depois de logado no sistema o usuário poderá cadastrar um Item achado ou perdido, ou até mesmo, listar os itens já cadastrados no sistema. 
Caso ele opite por cadastrar um item perdido, ele irá clicar no botão "Item Perdido" e será direcionado a uma outra janela para informar as características do item perdido(tipo, cor, quantidade e descrever bem detalhado as informações necessárias), e depois clica em cadastrar. 
Caso ele escolha cadastrar um item achado, ele deverá clicar no botão "Item Achado" e será direcionado a uma outra janela para informar as características do item achado(tipo, cor, quantidade, e a descrição), essa descrição deve ser bem detalhada, informando o local, departamento, e todas as características que identifique melhor o item achado, pois o ousuário que perdeu poderá ler os detalhes e pegar o item onde foi deixado. Depois clica em cadastrar.
Caso ele escolha o opção de listar itens deverá clicar no botão "Listar Itens", será direcionado a uma janela onde irá conter todos os itens cadastrados numa "table view" e ver onde o item foi encontrado, através da descrição de quem achou e o cadastrou.

#Ambiente de desenvolvimento: Eclipse
#Versão do java: 1.8.0_181
#Dependência(biblioteca): gson-2.6.2(Google)
#Scene Builder: javafx scenebuilder-2_0

#O projeto será implementado utilizando paradigma de Programação Orientada a Objetos na linguagem Java e servirá como projeto da disciplina de Introdução à Programação 2, sob tutoria do professor André Câmara.

#2018/07/26
Lançada versão Beta com interface gráfica devidamente implementada e funções de "Cadastrar item perdido" e "Cadastrar item achado".
