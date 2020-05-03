package Habbib.view;

import Habbib.controller.InstitutionController;
import Habbib.controller.SessionController;
import Habbib.model.Address;
import Habbib.model.Institution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends BaseView{

    public View() {
        super("Habbib beds");
        super.showWindow(loginContainer(), 620,520);
    }

    private Container loginContainer(){
        JPanel loginContainer = new JPanel();
        loginContainer.setLayout(null);

        JTextField userInput = super.createTextField(219,180,200,20);
        JPasswordField passInput = super.createPasswordField(219,206,200,20);

        loginContainer.add(super.createHeaderLabel("Habbib Beds", 230,50,140,40));
        loginContainer.add(super.createTitleLabel("Login", 280,125,50,30));
        loginContainer.add(super.createInputLabel("Usuário:", 155,180,60,20));
        loginContainer.add(super.createInputLabel("Senha:", 155,206,60,20));
        loginContainer.add(super.createTextLabel("Não tem uma conta?",219,400,120,20 ));

        loginContainer.add(userInput);
        loginContainer.add(passInput);
        loginContainer.setVisible(true);

        JButton registerButton = super.createButton("Crie uma", 340,400,81,20);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginContainer.setVisible(false);
                setContentPane(initRegister());
            }
        });


        JButton loginButton = super.createButton("Entrar", 219,232,200,20);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    SessionController sessionController = new SessionController();

                    Institution institution = sessionController.login(userInput.getText(), passInput.getText());
                    loginContainer.setVisible(false);
                    setContentPane(initMenu(institution));
                }
                catch (Exception ex)
                {
                    if(userInput.getText().equals("") || passInput.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Seu usuário ou senha está vazio", "WARNING",JOptionPane.WARNING_MESSAGE);

                    }else{
                        JOptionPane.showMessageDialog(null,"Seu usuário ou senha está incorreto.", "WARNING",JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });

        loginContainer.add(loginButton);
        loginContainer.add(registerButton);
        return loginContainer;
    }

    private Container initRegister(){
        JPanel registerContainer = new JPanel();
        registerContainer.setLayout(null);

        registerContainer.add(super.createHeaderLabel("Cadastro de usuário", 230,20,200,40));
        registerContainer.add(super.createInputLabel("Nome:",10,59,40,20));
        registerContainer.add(super.createInputLabel("CNPJ:",10,99,40,20));
        registerContainer.add(super.createInputLabel("Tipo:",408,99,60,20));
        registerContainer.add(super.createInputLabel("Endereco:",10,139,59,20));
        registerContainer.add(super.createInputLabel("CEP:",10,179,27,20));
        registerContainer.add(super.createInputLabel("Bairro:",212,179,39,20));
        registerContainer.add(super.createInputLabel("Número:",415,139,59,20));
        registerContainer.add(super.createInputLabel("Compl:",393,179,100,20));
        registerContainer.add(super.createInputLabel("Cidade:",10,219,45,20));
        registerContainer.add(super.createInputLabel("UF:",300,219,20,20));
        registerContainer.add(super.createInputLabel("Telefone:",415,219,59,20));
        registerContainer.add(super.createInputLabel("Senha:",10,259,40,20));
        registerContainer.add(super.createInputLabel("Confirmar senha:",276,259,104,20));
        registerContainer.add(super.createInputLabel("Voltar",86,428,109,311));
        registerContainer.add(super.createInputLabel("Confirmar",106,428,109,311));

        // chama a caixa de mensagem
        JTextField nameInput = super.createTextField(79,60,512,22);
        JTextField cnpjInput = super.createTextField(79,100,330,22);
        //JTextField typeInput = super.createTextField(490,100,100,20);
        JTextField addressInput = super.createTextField(79,139,330,22);
        JTextField zipCodeInput = super.createTextField(80,180,130,22);
        JTextField neighborhoodInput = super.createTextField(254,180,155,22);
        JTextField numberInput = super.createTextField(489,139,101,22);
        JTextField complementInput = super.createTextField(489,180,101,22);
        JTextField cityInput = super.createTextField(79,220,220,22);
        JTextField phoneInput = super.createTextField(489,220,101,22);
        JTextField passwordInput = super.createTextField(78,260,192,22);
        JTextField cPasswordInput = super.createTextField(390,260,200,22);
        JButton backButton1 = super.createButton("Voltar",82,428,109,22);
        JButton register = super.createButton("Confirmar",200,428,109,22);
        JComboBox typeInput = super.createComboBox(new String[]{"Selecionar","Particular", "Privado"},490,100,100,20);
        JComboBox UFCB = super.createComboBox(new String[]{"Selecionar","SP","RJ"},322,220,86,22);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente cadastrar?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    registerContainer.setVisible(false);
                    setContentPane(loginContainer());
                }
            }
        });


        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente voltar?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    registerContainer.setVisible(false);
                    setContentPane(loginContainer());
                }
            }
        });

        registerContainer.add(nameInput);
        registerContainer.add(cnpjInput);
        registerContainer.add(typeInput);
        registerContainer.add(addressInput);
        registerContainer.add(zipCodeInput);
        registerContainer.add(neighborhoodInput);
        registerContainer.add(numberInput);
        registerContainer.add(complementInput);
        registerContainer.add(cityInput);
        registerContainer.add(UFCB);
        registerContainer.add(phoneInput);
        registerContainer.add(passwordInput);
        registerContainer.add(cPasswordInput);
        registerContainer.add(backButton1);
        registerContainer.add(register);

        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerContainer.setVisible(false);
                setContentPane(loginContainer());

            }
        });

        JComboBox typeCB = super.createComboBox(new String[] { "Selecionar","Privado", "Público"}, 448,100,142,22);

        JButton registerButton = new JButton("Cadastrar");
        registerButton.setBounds(303,428,109,31);
        registerButton.setFont(new Font("Segoe UI Historic", 1, 16));
        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(UFCB.getSelectedItem().equals("Selecionar") || typeCB.getSelectedItem().equals("Selecionar")){
                        JOptionPane.showMessageDialog(null,"Dados inválidos, verifique se os campos estão preenchidos corretamente", "WARNING",JOptionPane.WARNING_MESSAGE);

                    }else {
                        //TODO Testar objetos
                        Institution institution = new Institution();
                        Address address = new Address();
                        InstitutionController registerInstitution = new InstitutionController();

                        //Adiciona as informações no objeto address
                        address.setZipCode(zipCodeInput.getText());
                        address.setAddress(addressInput.getText());
                        address.setNumber(Integer.parseInt(numberInput.getText()));
                        address.setComplement(complementInput.getText());
                        address.setNeighborhood(neighborhoodInput.getText());
                        address.setUf(UFCB.getSelectedItem().toString());
                        address.setCity(cityInput.getText());
                        address.setId(registerInstitution.registerAddress(address).getId());

                        //Adiciona as informações no objeto institution
                        institution.setCnpj(cnpjInput.getText());
                        institution.setName(nameInput.getText());
                        institution.setPassword(passwordInput.getText());
                        institution.setType(typeCB.getSelectedItem().toString());
                        institution.setContactNumber(phoneInput.getText());
                        institution.setAddress(address);
                        registerInstitution.registerInstitution(institution);
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        registerContainer.setVisible(false);
                        setContentPane(loginContainer());
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Dados inválidos, verifique se os campos estão preenchidos corretamente", "WARNING",JOptionPane.WARNING_MESSAGE);
                    System.out.println(ex);
                }
            }
        });

        registerContainer.add(super.createHeaderLabel("Cadastre sua instituição", 169,10, 251, 32));

        setVisible(true);
        return registerContainer;
    }

    private Container initMenu(Institution institution){
        JPanel menuContainer = new JPanel();
        menuContainer.setLayout(null);

        menuContainer.add(super.createHeaderLabel("Bem - vindo",178,10,251,32));

        JButton provider = super.createButtonAnotherSource("Fornecedor",84,166,167,61);
        provider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.setVisible(false);
                setContentPane(initProvider(institution));
            }
        });

        JButton requester = super.createButtonAnotherSource("Solicitante",351,166,167,61);
        requester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.setVisible(false);
                setContentPane(initRequester(institution));
            }
        });

        JButton registerBed = super.createButtonAnotherSource("Cadastrar Leito",84,287,167,61);
        registerBed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.setVisible(false);
                setContentPane(initRegisterBed(institution));
            }
        });

        JButton requestBed = super.createButtonAnotherSource("Solicitar",351,287,167,61);
        requestBed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuContainer.setVisible(false);
                setContentPane(initRequestBed(institution));
            }
        });

        JButton exit = super.createButton("Sair",10,427,78,30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente sair?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    menuContainer.setVisible(false);
                    setContentPane(loginContainer());
                }
            }
        });

        menuContainer.add(provider);
        menuContainer.add(requester);
        menuContainer.add(registerBed);
        menuContainer.add(requestBed);
        menuContainer.add(exit);

        setVisible(true);

        return menuContainer;
    }

    private Container initProvider(Institution institution){
        JPanel providerContainer = new JPanel();
        providerContainer.setLayout(null);

        providerContainer.add(super.createHeaderLabel("Tela de fornecedor", 178,10,251,32));

        providerContainer.add(super.createInputLabel("Instituição:",10,52,70,30));

        //TODO: (Puxar a instituição que está logado conforme Habbib_Latest 5/23)

        providerContainer.add(super.createInputLabelLeft("Status:",10,82,60,30));

        JComboBox pending = super.createComboBox(new String[]{"Pendente","Recusado","Aprovado"},10,122,89,26);

        // TODO:(Realizar busca)
        JTextField userInput = super.createTextField(109,122,393,30);

        // TODO: (Realizar busca)
        JButton consult = super.createButton("Consultar",512, 122, 78, 30);
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*providerContainer.setVisible(false);
                setContentPane(initMenu(institution));*/
            }
        });

        JButton exit = super.createButton("Sair",512, 427, 78, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                providerContainer.setVisible(false);
                setContentPane(initMenu(institution));
            }
        });

        providerContainer.add(pending);
        providerContainer.add(userInput);
        providerContainer.add(consult);
        providerContainer.add(exit);

        return providerContainer;
    }


    private Container initRequester(Institution institution){
        JPanel requesterContainer = new JPanel();
        requesterContainer.setLayout(null);

        requesterContainer.add(super.createHeaderLabel("Tela do solicitante", 178,10,251,32));

        requesterContainer.add(super.createInputLabelLeft("Status:",10,82,60,30));

        JComboBox pending = super.createComboBox(new String[]{"Todos","Recusado","Aprovado"},10,122,89,26);

        // TODO:(Realizar busca)
        JTextField userInput = super.createTextField(109,122,393,30);

        // TODO: (Realizar busca)
        JButton consult = super.createButton("Consultar",512, 122, 78, 30);
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*providerContainer.setVisible(false);
                setContentPane(initMenu(institution));*/
            }
        });

        JButton exit = super.createButton("Sair",512, 427, 78, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                requesterContainer.setVisible(false);
                setContentPane(initMenu(institution));
            }
        });

        requesterContainer.add(userInput);
        requesterContainer.add(pending);
        requesterContainer.add(consult);
        requesterContainer.add(exit);

        return requesterContainer;
    }

    private Container initRegisterBed(Institution institution){
        JPanel registerBedContainer= new JPanel();
        registerBedContainer.setLayout(null);

        JButton exit = new JButton("Sair");
        exit.setBounds(10, 427,78, 30 );
        exit.setFont(new Font("Segoe UI Historic", 0, 16));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registerBedContainer.setVisible(false);
                setContentPane(initMenu(institution));
            }

        });

        registerBedContainer.add(super.createHeaderLabel("Tela do Cadastrar leito", 150,10,300,32));
        registerBedContainer.add(super.createInputLabel("Tipo:",10,60,100,20));
        registerBedContainer.add(super.createInputLabel("Quantidade:",30,100,100,20));
        registerBedContainer.add(super.createInputLabel("Descrião da solicitação",160,140,300,32));

        JComboBox typeInput = super.createComboBox(new String[]{"Selecionar","UTI", "Semi-intensivo","Baixa Complexidade"},245,60,120,20);
        JTextField amountInput = super.createTextField(245,100,25,22);
        JTextField boxtext = super.createTextField(40,180,520,220);
        JButton backButton2 = super.createButton("Voltar",90,427,78, 30 );

        registerBedContainer.add(typeInput);
        registerBedContainer.add(amountInput);
        registerBedContainer.add(boxtext);
        registerBedContainer.add(backButton2);
        registerBedContainer.add(exit);

        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente voltar?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    registerBedContainer.setVisible(false);
                    setContentPane(loginContainer());
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente sair?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    registerBedContainer.setVisible(false);
                    setContentPane(loginContainer());
                }
            }
        });
        return registerBedContainer;

    }

    private Container initRequestBed(Institution institution){
        JPanel requestBedContainer= new JPanel();
        requestBedContainer.setLayout(null);

        requestBedContainer.add(super.createInputLabel("Tipo:",10,59,40,20));

        requestBedContainer.add(super.createHeaderLabel("Solicitar leito", 160,10,251,32));

        requestBedContainer.add(super.createInputLabel("Tipo:",10,52,70,30));

        requestBedContainer.add(super.createInputLabel("Bairro:",157,52,70,30));

        requestBedContainer.add(super.createInputLabel("Leito:",372,52,70,30));

        JComboBox status = super.createComboBox(new String[]{"Privado","Público"},10,92,89,26);

        JComboBox neighborhood = super.createComboBox(new String[]{"Mooca","Tatuapé","..."},157,92,89,26);

        JComboBox type = super.createComboBox(new String[]{"UTI","Semi-intensivo","Baixa complexidade"},372,92,89,26);

        // TODO: (Realizar busca)
        JButton consult = super.createButton("Consultar",512, 92, 78, 30);
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*providerContainer.setVisible(false);
                setContentPane(initMenu(institution));*/
            }
        });

        // TODO:(Realizar busca)
        JTextField userInput = super.createTextField(10,139,580,30);

        JButton exit = super.createButton("Sair",512, 427, 78, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                requestBedContainer.setVisible(false);
                setContentPane(initMenu(institution));
            }
        });

        requestBedContainer.add(status);
        requestBedContainer.add(neighborhood);
        requestBedContainer.add(type);
        requestBedContainer.add(consult);
        requestBedContainer.add(userInput);
        requestBedContainer.add(exit);

        return  requestBedContainer;
    }
}