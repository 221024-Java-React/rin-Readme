
document.getElementById("submitPokemon").addEventListener("click", getPokemon);

async function getPokemon(e){
    e.preventDefault();
    let pokemon = document.getElementById("pokemonInput").value;
    const URL = `https://pokeapi.co/api/v2/pokemon/${pokemon}`;
    
    fetch(URL)
    .then((response)=> response.json())
    .then((data)=> {
        document.getElementById("display").innerHTML = `
        <h1>${data.name}</h1>
        <br><br>
        <img src="${data.sprites.other["official-artwork"].front_default}"
            alt="${data.name}"/>`;

    }).catch((err)=>{
        console.log("Pokemon not found", err);
    })
}

