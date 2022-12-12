const hozzaadBtn = document.querySelector('#btn')
const num = document.querySelector('#num')
const output = document.querySelector('output')
const span = document.querySelector('span')

myList = []
selectedElements = []

hozzaadBtn.addEventListener('click', hozzaadF)
output.addEventListener('click', makeTextRed)

function hozzaadF() {
  value = num.value
  if (!isNaN(value)) {
    if (isHighest(value)) {
      myList.push(value)
      updateDisable()
      appendOutput(value)
      avg()
      makeDefault()
    }
  }
}

function isHighest(value) {
  max = Math.max(...myList)

  return value > max
}

function updateDisable() {
  if (!isListLengthOK()) {
    hozzaadBtn.disabled = true
  }
}

function isListLengthOK() {
  return myList.length < 5
}

function appendOutput(val) {
  const p = document.createElement('p')
  p.textContent = value
  output.appendChild(p)
}

function makeTextRed(e) {
  e.target.style.color = 'red'
  selectedElements.push(e.target.innerText)
}

function makeDefault() {
  elementsList = output.getElementsByTagName('p')
  selectedElements = []

  console.log(elementsList)
  for (i = 0; i < elementsList.length; i++) {
    elementsList[i].style.color = ''
  }
}

function avg() {
  i = 0
  sum = 0
  while (i < myList.length) {
    item = parseInt(myList[i])
    sum += item
    i++
  }

  span.innerText = sum / myList.length
}
