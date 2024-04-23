// Функция для загрузки информации о клиенте с сервера
function loadClientInfo() {
    fetch('/api/v1/client/me')
        .then(response => response.json())
        .then(data => {
            displayClientInfo(data);
        })
        .catch(error => console.error('Ошибка при загрузке информации о клиенте:', error));
}

// Функция для отображения информации о клиенте на странице
function displayClientInfo(client) {
    const clientInfoDiv = document.getElementById('client-info');
    clientInfoDiv.innerHTML = `
        <h2>Информация о клиенте</h2>
        <p>Имя: ${client.firstName}</p>
        <p>Фамилия: ${client.lastName}</p>
        <!-- Другие поля информации о клиенте -->
        <button onclick="showEditForm()">Редактировать</button>
    `;
}

// Функция для отображения формы редактирования информации о клиенте
function showEditForm() {
    const editFormDiv = document.getElementById('edit-form');
    editFormDiv.style.display = 'block';
}

// Функция для отправки данных формы редактирования на сервер
function saveClientInfo() {
    const formData = new FormData(document.getElementById('edit-form'));
    fetch('/api/v1/client/edit', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        console.log('Информация о клиенте успешно обновлена:', data);
        // После успешного обновления информации, скрываем форму редактирования
        document.getElementById('edit-form').style.display = 'none';
        // Загружаем обновленные данные о клиенте
        loadClientInfo();
    })
    .catch(error => console.error('Ошибка при сохранении информации о клиенте:', error));
}

// При загрузке страницы загружаем информацию о клиенте
window.onload = loadClientInfo;



