document.addEventListener('DOMContentLoaded', () => {
  const input = document.querySelector('input[type="number"]');
  const btnIncrease = document.getElementById('button-increase');
  const btnDecrease = document.getElementById('button-decrease');

  if (!input || !btnIncrease || !btnDecrease) {
    console.error('No se encontraron los elementos necesarios');
    return;
  }

  btnIncrease.addEventListener('click', () => {
    let val = parseInt(input.value) || 1;
    const max = parseInt(input.max) || Infinity;
    if (val < max) input.value = val + 1;
  });

  btnDecrease.addEventListener('click', () => {
    let val = parseInt(input.value) || 1;
    const min = parseInt(input.min) || 1;
    if (val > min) input.value = val - 1;
  });
});
