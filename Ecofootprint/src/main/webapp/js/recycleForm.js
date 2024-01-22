const fileDrop = document.getElementById('fileDrop');
const fileInput = document.getElementById('uploadBill');

fileDrop.addEventListener('dragover', (e) => {
    e.preventDefault();
    fileDrop.classList.add('file-drop-hover');
});

fileDrop.addEventListener('dragleave', () => {
    fileDrop.classList.remove('file-drop-hover');
});

fileDrop.addEventListener('drop', (e) => {
    e.preventDefault();
    fileDrop.classList.remove('file-drop-hover');

    const files = e.dataTransfer.files;
    if (files.length > 0) {
        fileInput.files = files;
    }
});

fileDrop.addEventListener('click', () => {
    fileInput.click();
});

fileInput.addEventListener('change', () => {
    const files = fileInput.files;
    if (files.length > 0) {
        // Optionally display the selected file name or perform other actions
        console.log('Selected file:', files[0].name);
    }
});