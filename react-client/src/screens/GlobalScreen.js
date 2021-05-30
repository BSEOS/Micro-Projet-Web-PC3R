import React, { Component } from 'react';
import { Col, Container, Row, Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/header';


class GlobalScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            menuOpen: false,
            loading: true,
            item: [],
        }
    }

    fetchData() {
        // alert("called")
        this.setState({
            loading: true
        })
        fetch("http://localhost:8080/crypto-adviser/global")
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result);
                    this.setState({
                        loading: false,
                        item: result[0]
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



    render() {
        return (
            <div className="wrapper home">
                <Header title="global" left="bars" right="redo" />

                <div className="main-container">
                    <Container>
                        {
                            this.state.loading ? <p>loading ...</p> :
                                <Row className="mt-5">
                                    <Col>
                                        <h3 className="text-white text-center mb-3">
                                            Global Currencies Data
                                        </h3>
                                        <Table striped bordered hover size="sm" className="bg-white">
                                            <thead>
                                                <tr>
                                                    <th>Coins Count</th>
                                                    <th>Active Markets</th>
                                                    <th>Total Market Cap</th>
                                                    <th>Total Volume</th>
                                                    <th>BTC-D</th>
                                                    <th>Volume Change</th>
                                                    <th>AVG Change</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                {
                                                    <tr>
                                                        <td>
                                                            {this.state.item.coins_count}
                                                        </td>
                                                        <td>
                                                            {this.state.item.active_markets}
                                                        </td>
                                                        <td>
                                                            {this.state.item.total_mcap}
                                                        </td>
                                                        <td>
                                                            {this.state.item.total_volume}
                                                        </td>
                                                        <td>
                                                            {this.state.item.btc_d}
                                                        </td>
                                                        <td>
                                                            {this.state.item.volume_change}
                                                        </td>
                                                        <td>
                                                            {this.state.item.avg_change_percent + "%"}
                                                        </td>
                                                    </tr>

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
export default GlobalScreen