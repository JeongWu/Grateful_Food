import React, { Component } from "react";
import { Nav, Form, Button, Container, Row, Col,Table,Badge } from "react-bootstrap";
import img from "../img/logo.png";
import "../App.css";
class Myinfo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode: 1,
      key : "profile"
    };
  }
  render() {
    const { mode,key } = this.state;
    const handleselect=eventKey=> this.setState({ key : eventKey });
    return (
      <>
        {mode === 1 ? (
          <Container>
            <Form>
              <Form.Group controlId="formBasicEmail">
                <Form.Label>ID</Form.Label>
                <Form.Control type="email" placeholder="ID" />
              </Form.Group>

              <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
              <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="자동 로그인" />
              </Form.Group>
            </Form>

            <Button
              variant="primary"
              type="submit"
              onClick={() => this.setState({ mode: mode === 1 ? 2 : 1 })}
            >
              로그인
            </Button>
            <Button variant="secondary">취소</Button>
          </Container>
        ) : (
          <Container>
            <Row>
              <div className="My">
                <h2>마이페이지</h2>
              </div>
              <div className="tab2"></div>
            </Row>
            <Nav variant="tabs" activeKey={key} onSelect={handleselect}>
              <Nav.Item>
                <Nav.Link eventKey="profile">회원정보</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                <Nav.Link eventKey="order">주문내역</Nav.Link>
              </Nav.Item>
            </Nav>
            {key==="profile" ? (
            <Form>
              <Form.Group as={Row} controlId="formPlaintextEmail">
                <Col>
                  <div>
                    <img src={img} className="profile"></img>
                  </div>
                </Col>
                <Col sm="7"></Col>
                <Col></Col>
              </Form.Group>
              <Form.Group as={Row} controlId="formPlaintextEmail">
                <Form.Label column sm="2">
                  아이디
                </Form.Label>
                <Col sm="7">
                  <Form.Control
                    plaintext
                    readOnly
                    defaultValue="email@example.com"
                  />
                </Col>
                <Col></Col>
              </Form.Group>

              <Form.Group as={Row} controlId="formPlaintextPassword">
                <Form.Label column sm="2">
                  비밀번호 변경
                </Form.Label>
                <Col sm="7">
                  <Form.Control
                    type="password"
                    placeholder="변경할 비밀번호 입력"
                  />
                </Col>
              </Form.Group>
              <Form.Group as={Row}>
                <Col sm="2"></Col>
                <Col sm="7">
                  <Form.Control type="password" placeholder="재입력" />
                </Col>
                <Col>
                  <Button>확인</Button>
                </Col>
              </Form.Group>
            </Form>
            ) : (
              <Table striped bordered hover size="sm">
  <thead>
    <tr>
      <th>#</th>
      <th>음식점</th>
      <th>메뉴</th>
      <th>시간</th>
      <th>상태</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Mark</td>
      <td>Otto</td>
      <td>2020.02.12</td>
      <td><Badge pill variant="danger">준비중</Badge></td>
    </tr>
    <tr>
      <td>2</td>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>2020.02.12</td>
      <td><Badge pill variant="success">배달완료</Badge></td>
    </tr>
    <tr>
      <td>3</td>
      <td colSpan="2">Larry the Bird</td>
      <td>2020.02.12</td>
      <td><Badge pill variant="primary">배달중</Badge></td>
    </tr>
  </tbody>
</Table>
            )}
          </Container>
          
        )}
      </>
    );
  }
}

export default Myinfo;
