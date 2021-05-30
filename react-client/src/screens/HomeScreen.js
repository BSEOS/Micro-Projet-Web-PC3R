import React, { Component } from 'react';
import { Col, Container, Row, Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/header';


class HomeScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            menuOpen: false,
            loading: true,
            items: [],
        }
    }

    fetchData() {
        // alert("called")
        this.setState({
            loading: true
        })
        fetch("http://localhost:8080/crypto-adviser/board")
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result);
                    this.setState({
                        loading: false,
                        items: result.data
                    });
                },

                (error) => {
                    this.setState({
                        loading: false,
                        error
                    });
                }
            )
    }

    componentDidMount() {
        setInterval(async () => await this.fetchData(), 10000)



    }


    // data": [
    //     {
    //       "id": "90",
    //       "symbol": "BTC",
    //       "name": "Bitcoin",
    //       "nameid": "bitcoin",
    //       "rank": 1,
    //       "price_usd": "36245.72",
    //       "percent_change_24h": "3.51",
    //       "percent_change_1h": "1.23",
    //       "percent_change_7d": "-2.39",
    //       "price_btc": "1.00",
    //       "market_cap_usd": "676434039172.47",
    //       "volume24": 49858935678.40042,
    //       "volume24a": 55812760456.74331,
    //       "csupply": "18662452.00",
    //       "tsupply": "18662452",
    //       "msupply": "21000000"
    //     }
    render() {
        return (
            <div className="wrapper home">
                <Header title="home" left="bars" right="redo" />

                <div className="main-container">
                    <Container>
                        {
                            this.state.loading ? <p>loading ...</p> :
                                <Row className="mt-5">
                                    <Col>
                                        <h3 className="text-white text-center mb-3">
                                            Live currency prices
                                        </h3>
                                        <Table striped bordered hover size="sm" className="bg-white">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>
                                                        Coin
                                                    </th>
                                                    <th>Price</th>
                                                    <th>Market Cap</th>
                                                    <th>24h volume</th>
                                                    <th>1h</th>
                                                    <th>24h</th>
                                                    <th>7d</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {
                                                    this.state.items && this.state.items.map((item, i) =>
                                                        <tr>
                                                            <td>{i + 1}</td>
                                                            <td>
                                                                <Link to={`/coins/${item.id}`}>
                                                                    {item.name}
                                                                </Link>
                                                            </td>
                                                            <td>
                                                                {item.price_usd + " $"}
                                                            </td>
                                                            <td>
                                                                {item.market_cap_usd + " $"}
                                                            </td>
                                                            <td>
                                                                {item.volume24 + " $"}
                                                            </td>
                                                            <td>
                                                                {item.percent_change_1h + "%"}
                                                            </td>
                                                            <td>
                                                                {item.percent_change_24h + "%"}
                                                            </td>
                                                            <td>
                                                                {item.percent_change_7d + "%"}
                                                            </td>
                                                        </tr>
                                                    )
                                                }

                                            </tbody>
                                        </Table>
                                    </Col>
                                </Row>
                        }

                    </Container>
                </div>

            </div>
        );


    }
}
export default HomeScreen