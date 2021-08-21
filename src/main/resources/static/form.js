window.onload = function () {
    document.getElementById('more').onclick = function () {
        if (this.checked)
            document.getElementById('yourDiv').style.display = 'block';
        else
            document.getElementById('yourDiv').style.display = 'none';
    }
}