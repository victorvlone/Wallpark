const alterarBtn = document.getElementById('alterar');
const adicionarBtn = document.getElementById('adicionar');
const excluirBtn = document.getElementById('excluir');
const servicePrice = document.getElementById('service-price');
const paymentInput = document.getElementById('payment-input');
const serviceContainer = document.getElementById('container-service');
const actionBtn = document.getElementById('actionButton');
const inputCorVaga = document.getElementById('inputCor-vaga');
const tipodeCarro = document.getElementById('tipodeCarro');
const modelodeCarro = document.getElementById('modelo-carro');
const placa = document.getElementById('placa');
const placaInput = document.getElementById('placa-input');
const logoBtn = document.querySelector(".logo-button");
const containerRl = document.querySelector(".container-register-login");
const loginOption = document.getElementById('login-option'); 
const registerOption = document.getElementById('register-option'); 
const containerRegister = document.querySelector(".container-register");
const containerLogin = document.querySelector(".container-login");

logoBtn.addEventListener("click", () => {
    logoBtn.style.left = '291.5px'
    setTimeout(() => {
        containerRl.classList.toggle("visible");
    }, 300);
});

loginOption.addEventListener("click", () => {
    containerRegister.style.display = 'none';
    containerLogin.style.display = 'flex';
});

registerOption.addEventListener("click", () => {
    containerRegister.style.display = 'flex';
    containerLogin.style.display = 'none';
});

const buttons = [alterarBtn, excluirBtn, adicionarBtn];

function resetDisplay () {
    servicePrice.style.display = 'none';
    paymentInput.style.display = 'none';
    inputCorVaga.style.display = 'none';
    modelodeCarro.style.display = 'none';
    tipodeCarro.style.display = 'none';
}

function resetButtonColors() {
    buttons.forEach(button => button.style.backgroundColor = '#303030');
}

function showElements(...elements){
    elements.forEach(element => {
        element.style.display = 'flex';
    });
}

function resetPlacaStyles(){
    placa.style.alignItems= '';
    placa.style.width = '';
    placaInput.style.width = '';
}

alterarBtn.addEventListener('click', () => {
    resetDisplay();
    resetButtonColors();
    resetPlacaStyles();
    alterarBtn.style.backgroundColor = '#B8A15A';
    actionBtn.style.backgroundColor = '#B8A15A';
    serviceContainer.style.height = '454px';
    actionBtn.textContent = 'Alterar';
    showElements(inputCorVaga, modelodeCarro, tipodeCarro);
});

adicionarBtn.addEventListener('click', () => {
    resetDisplay();
    resetButtonColors();
    resetPlacaStyles();
    adicionarBtn.style.backgroundColor = '#B8A15A';
    actionBtn.style.backgroundColor = '#B8A15A';
    serviceContainer.style.height = '554px';
    actionBtn.textContent = 'Adicionar';
    showElements(servicePrice, paymentInput, inputCorVaga, modelodeCarro, tipodeCarro);
});

excluirBtn.addEventListener('click', () => {
    resetDisplay();
    resetButtonColors();
    actionBtn.style.backgroundColor = '#D70000';
    excluirBtn.style.backgroundColor = '#B8A15A';
    adicionarBtn.style.backgroundColor = '#303030';
    alterarBtn.style.backgroundColor = '#303030';
    serviceContainer.style.height = '380px';
    actionBtn.textContent = 'Excluir';
    placa.style.alignItems= 'center';
    placa.style.width = '100%';
    placaInput.style.width = '60%';
});
