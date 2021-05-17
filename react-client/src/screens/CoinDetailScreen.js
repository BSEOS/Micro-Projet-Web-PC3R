
import React, { Component } from 'react';
import { useState } from 'react';
import { Card, Col, Container, Row, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import AddReportModal from '../components/AddReportModal';
import Header from '../components/header';

export default function CoinDetailScreen(props) {

    const [showAddModal, setShowAddModal] = useState(false)



    return (
        <div className="wrapper home">
            <Header title="home" left="bars" right="redo" />

            <div className="main-container">
                <Container>
                    <Row className="mt-5 ">
                        <Col className="text-right bg-white rounded">
                            <Button variant="info my-3" onClick={() => setShowAddModal(true)}>
                                Add
				            </Button>
                        </Col>
                    </Row>
                    <Row className="mt-5">
                        <Col>
                            <Card className="text-center mb-3">
                                <Card.Header>Featured</Card.Header>
                                <Card.Body>
                                    <Card.Title>Special title treatment</Card.Title>
                                    <Card.Text>
                                        With supporting text below as a natural lead-in to additional content.
                                        </Card.Text>
                                </Card.Body>
                                <Card.Footer className="text-muted">2 days ago</Card.Footer>
                            </Card>

                            {
                                showAddModal &&
                                <AddReportModal
                                    show={showAddModal}
                                    close={() => setShowAddModal(false)}
                                />
                            }
                        </Col>
                    </Row>
                </Container>
            </div>

        </div>
    );


}
