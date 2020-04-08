import React, { Component } from "react";
import { Nav, Form, Button, Container, Row, Col } from "react-bootstrap";
import img from "../img/logo.png";

class Myinfo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode: 1
    };
  }
  render() {
    const { mode } = this.state;
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
            <Nav variant="tabs" defaultActiveKey="/home">
              <Nav.Item>
                <Nav.Link href="#">회원정보</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                <Nav.Link href="#">주문내역</Nav.Link>
              </Nav.Item>
            </Nav>
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
          </Container>
        )}
      </>
    );
  }
}

export default Myinfo;
