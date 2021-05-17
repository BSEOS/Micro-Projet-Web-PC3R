import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import LoginScreen from "./screens/LoginScreen";
import RegisterScreen from "./screens/RegisterScreen";
import HomeScreen from "./screens/HomeScreen";
import CoinDetailScreen from './screens/CoinDetailScreen';
import CoinSummaryScreen from './screens/CoinSummaryScreen';

function App() {
	return (
		<Router>
			<div className="App">
				<Switch>
					<Route exact path='/' component={HomeScreen} />
					<Route path="/login" component={LoginScreen} />
					<Route path="/register" component={RegisterScreen} />
					<Route path="/coins/:id/summary/:summaryID" component={CoinSummaryScreen} />
					<Route path="/coins/:id" component={CoinDetailScreen} />
				</Switch>

			</div>
		</Router>
	);
}

export default App;
