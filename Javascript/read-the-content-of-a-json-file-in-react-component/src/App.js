import './App.css';
import {useEffect, useState} from "react";

function App() {

  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(process.env.PUBLIC_URL + '/data.json')
        .then(response => response.json())
        .then(jsonData => setData(jsonData))
        .catch((error) => console.error('Error reading JSON file →', error));
  }, []);

  console.log(data)

  return (
    <div className="App">
      {/*  Demo code */}
    </div>
  );
}

export default App;
